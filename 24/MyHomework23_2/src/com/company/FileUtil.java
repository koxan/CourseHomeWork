package com.company;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static long directorySize(File file) {
        long size = 0;
        if (file.exists()) {
            if (!file.isDirectory()) {
                size = file.length();
            } else {
                for (File current : file.listFiles()) {
                    size += directorySize(current);
                }
            }
        }
        return size;
    }

    public static long directorySize(String filePath) throws WrongPathException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new WrongPathException("Ошибка! Неверный путь.");
        }
        return directorySize(file);
    }

    public static File getFileFromDialog() throws CancelOptionChooseException {
        JFileChooser chooseDialog = new JFileChooser(".");
        chooseDialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (chooseDialog.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) {
            throw new CancelOptionChooseException("Файл/директория не выбран(а).");
        }
        return chooseDialog.getSelectedFile();
    }

    public static String getPathAndSizeMessage(File file, long size) {
        String result = "";
        System.out.print("Размер директории/файла \"" + file.getAbsolutePath() + "\": \n" + size + " байт");
        if (size > 1024 * 1024 * 1024) {
            result += "(" + size / 1024 / 1024 / 1024 + " гигабайт)";
        } else if (size > 1024 * 1024) {
            result += "(" + size / 1024 / 1024 + " мегабайт)";
        } else if (size > 1024) {
            result += "(" + size / 1024 + " килобайт)";
        }
        return result;
    }

    public static String getPathAndSizeMessage(String line, long size) {
        return getPathAndSizeMessage(new File(line), size);
    }

    public static File searchByContent(File file, String search) {
        if (file.exists()) {
            if (!file.isDirectory()) {

                if (isFileTxt(file) && findInFile(file, search)) {
                    return file;
                }
            } else {
                for (File current : file.listFiles()) {
                    File searchedFile = searchByContent(current, search);
                    if (searchedFile != null) {
                        return searchedFile;
                    }
                }
            }
        }
        return null;
    }

    public static File searchByContent(String pathTofile, String search) {
        return searchByContent(new File(pathTofile), search);
    }

    private static boolean findInFile(File file, String search) {
        String line = "";
        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in);
             BufferedReader br = new BufferedReader(reader)) {
            while ((line = br.readLine()) != null) {
                if (line.contains(search)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isFileTxt(File file) {
        char[] fileName = file.getName().toCharArray();
        String fileExtension = "", txtExtension = "txt";
        boolean isAfterDot = false;
        for (int i = 0; i < fileName.length; i++) {
            if (isAfterDot) {
                fileExtension += fileName[i];
            }
            if (fileName[i] == '.') {
                isAfterDot = true;
            }
        }
        if (fileExtension.equals(txtExtension)) {
            return true;
        }
        return false;
    }


    public static List<File> searchByContentSecondVariant(File file, String search) {
        List<File> foundedFiles = new ArrayList<>();
        searchByContentSecondVariantInner(file, search, foundedFiles);
        return foundedFiles;
    }

    private static void searchByContentSecondVariantInner(File file, String search, List<File> list) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                // тот же &&
                if (isFileTxt(file) && findInFile(file, search)) {
                    list.add(file);
                }
            } else {
                for (File current : file.listFiles()) {
                    searchByContentSecondVariantInner(current, search, list);
                }
            }
        }
    }
}
