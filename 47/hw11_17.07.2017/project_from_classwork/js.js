var arr1=[3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3];
console.log("arr1 = " + arr1);
countMaxElem(arr1);

function countMaxElem() {
    var arr = arguments[0];
    if (arr === null) {
        alert("Error!");
        return;
    }

    var findElemArr = new Array(0);

    while(arr.length > 0) {
        var findElemArrLine = new Array(0);
        var i = 0;

        var findElem = arr[0];
        //console.log();
        //console.log("arr.length = " + arr.length);

        while(i < arr.length) {
            //console.log("arr[" + i + "] = " + arr[i] + ", arr = " + arr);
            if (findElem === arr[i]) {
                findElemArrLine.push(arr[i]);
                arr.splice(i, 1);
                i--;
            }
            i++;
        }
        findElemArr.push(findElemArrLine);

        //console.log("findElemArr = [" + findElemArr + "]");
        //console.log("arr = [" + arr + "]");
    }
    console.log(findElemArr);

    var maxIdx = -1;
    var maxCount = -1;
    for(let i = 0; i < findElemArr.length; i++) {
        if (maxCount < findElemArr[i].length) {
            maxCount = findElemArr[i].length;
            maxIdx = i;
        }
    }
    console.log("maxIdx = " + maxIdx);
    console.log(findElemArr[maxIdx][0] + " ( " + findElemArr[maxIdx].length + " times )");
}