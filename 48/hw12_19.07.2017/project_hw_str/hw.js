function isPalindrom(str) {
    var middle = str.length / 2;
    var left = 0;
    var right = 0;

    // сдвигаем отсчет для левой и правой части в зависимости от четного/нечетного размера строки
    if (middle % 2 == 0) {
        left = middle - 1;
        right = middle;
    } else {
        middle = parseInt(middle);
        left = middle - 1;
        right = middle + 1;
    }

    // шагаем влево и вправо, сверяя идентичность
    while (left >= 0 && right < str.length) {
        if (str[left] === str[right]) {

        } else {
            return false;
        }
        left--;
        right++;
    }
    return true;
}

function ucFirst(str) {
    // если пустая строка, то нет ошибки
    if (str === '') {
        return str;
    }

    var splitedWords = str.split(' ');
    str = '';
    for (let i = 0; i < splitedWords.length - 1; i++) {
        var word = splitedWords[i];
        word = word[0].toUpperCase() + word.slice(1, word.length);
        str += word + ' ';
    }
    word = splitedWords[splitedWords.length - 1];
    word = word[0].toUpperCase() + word.slice(1, word.length);
    str += word;
    return str;
}

function checkSpam(str) {
    if (str === "") {
        return true;
    }
    str = str.toLowerCase();
    return str.indexOf("viagra") > 0 || str.indexOf("xxx") > 0;
}

function extractCurrencyValue(str) {
    var strNum = '';
    for (let i = 0; i < str.length; i++) {
        if (!isNaN(str[i])) {
            strNum += str[i];
        }
    }
    return parseInt(strNum);
}

function toAlphaBet(str) {
    console.log(str);
    var charArray = new Array(0);
    for (let i = 0; i < str.length; i++) {
        charArray[i] = str[i];
    }
    console.log(charArray);

    // первое что пришло в голову
    // for (let i = 0; i < charArray.length; i++) {
    //     for (let j = 0; j < charArray.length - 1; j++) {
    //         if (charArray[j].codePointAt(0) > charArray[j + 1].codePointAt(0)) {
    //             var tmp = charArray[j];
    //             charArray[j] = charArray[j + 1];
    //             charArray[j + 1] = tmp;
    //         }
    //     }
    // }

    // пузырьковая сортировка
    for (let i = charArray.length - 1; i > 0; i--) {
        for (let j = 0; j < i; j++) {
            if (charArray[j].codePointAt(0) > charArray[j + 1].codePointAt(0)) {
                var tmp = charArray[j];
                charArray[j] = charArray[j + 1];
                charArray[j + 1] = tmp;
            }
        }
    }

    //

    str = '';
    for (let i = 0; i < charArray.length; i++) {
        str += charArray[i];
    }

    console.log(str);
    return str;
}
