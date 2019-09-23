function addArrayToDOM() {
    // * Функция возвращает false, если:
    // - Отсутствует какой-либо из параметров функции
    // - В этих случаях содержимое элемента не должно изменяться
    if (typeof (arguments[0]) === 'undefined' || typeof (arguments[1]) === 'undefined') {
        return false;
    }

    var secondArg = arguments[1];
    // * Функция возвращает false, если:
    // - Содержимое массива не является ни строкой, ни числом
    // - В этих случаях содержимое элемента не должно изменяться
    for(let i = 0; i < secondArg.length; i++) {
        if(!typeof (secondArg[i]) === 'string' || !typeof (secondArg[i]) === 'number') {
            return false;
        }
    }

    var firstArg = arguments[0];
    var isString = false;
    var objDom;

    if (typeof (firstArg) === 'string') {
        isString = true;
    }

    if (isString) {
        // * Если предоставлен идентификатор, выберите элемент в дереве
        objDom = document.getElementById(firstArg);
        if (objDom === null) {
            // * Функция возвращает false, если:
            // - Предоставленный id не выбирает ничего (нет элемента, который имеет такой идентификатор)
            // - В этих случаях содержимое элемента не должно изменяться
            return false;
        }
    } else {
        objDom = firstArg;
        var elems = document.getElementsByTagName(objDom.tagName);
        var isFind = false;
        for (let i = 0; i < elems.length; i++) {
            if (elems[i] === objDom) {
                isFind = true;
                break;
            }
        }

        // * Функция возвращает false, если:
        // - Предоставленный первый параметр не является ни строкой, ни существующим элементом DOM
        // - В этих случаях содержимое элемента не должно изменяться
        if (!isFind) {
            return false;
        }
    }

    // * Функция должна удалить все содержимое из предоставленного элемента DOM
    objDom.innerHTML = '';

    // * Добавить div элементы к найденому или предоставленому элементу DOM (см. атрибут innerHTML)
    //     - Содержимое каждого div должно быть одним из элементов массива содержимого
    for (let i = 0; i < secondArg.length; i++) {
        objDom.innerHTML += '<div>' + secondArg[i] + '</div>';
    }

    // * Во всех остальных случаях функция возвращает true
    return true;
}

function goJs() {
    console.log(addArrayToDOM('main', ['first div element', 'next div element', 6])); // === true;
    console.log(addArrayToDOM(document.getElementById('content'), ['first div element', 'next div element', 6])); // === true;
    console.log(addArrayToDOM('side', ['first div element', 'next div element', []])); // === false;

    // проверка случая с передаванием удаленного элемента
    var elem = document.getElementById('delElem');
    elem.parentNode.removeChild(elem);
    console.log(addArrayToDOM(elem, [1]));
}