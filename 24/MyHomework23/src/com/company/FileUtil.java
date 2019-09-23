package com.company;

import javax.swing.*;
import java.io.File;

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
}
