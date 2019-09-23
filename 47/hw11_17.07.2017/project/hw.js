function array_clone(arr) {
    var arrNew = new Array(arr.length);
    for(let i = 0; i < arr.length; i++) {
        var elem = arr[i];
        if (elem[0] === undefined) {
        } else {
            elem = array_clone(elem);
        }
        arrNew[i] = elem;
    }
	return arrNew;
}

function summ_kv() {
	var arr = arguments[0];
    var summKv = 0;
	for (let val of arr) {
		summKv += val * val;
	}
	return summKv;
}

function array_shuffle(arr) {
    var randCount = Math.floor(Math.random() * arr.length + 1);
    for (let i = 0; i < randCount; i++) {
        var oldPos = Math.floor(Math.random() * arr.length);
        var newPos = Math.floor(Math.random() * arr.length);
        var elem1 = arr[oldPos];
        var elem2 = arr[newPos];
        arr.splice(oldPos, 1, elem2);
        arr[newPos] = elem1;
    }
	return arr;
}

function unique(arr) {
    var findElemArr = new Array(0);

    while(arr.length > 0) {
        var findElemArrLine = new Array(0);
        var i = 0;

        var findElem = arr[0];

        while(i < arr.length) {
            if (findElem === arr[i]) {
                findElemArrLine.push(arr[i]);
                arr.splice(i, 1);
                i--;
            }
            i++;
        }
        findElemArr.push(findElemArrLine);

    }

    var uniqueArr = new Array(0);
    for(let i = 0; i < findElemArr.length; i++) {
        if (findElemArr[i].length === 1) {
            uniqueArr.push(findElemArr[i][0]);
        }
    }
	return uniqueArr;
}