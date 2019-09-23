window.onload = function () {
    prepareGame();
};

function prepareGame() {
    let field = document.getElementById('field');

    // for(let i = 0; i < 8; i++) {
    //     for(let j = 0; j < 8; j++) {
    //         let square = document.createElement('div');
    //         square.dragable = 'true';
    //         square.addEventListener('drop', dropChecker);
    //         square.classList.add('square');
    //         if((i + j) % 2 != 0) {
    //             square.classList.add('black');
    //         }
    //         field.appendChild(square);
    //     }
    // }

    let square = document.createElement('div');
    square.classList.add('square', 'black');

    let square2 = document.createElement('div');
    square2.classList.add('square', 'black');

    field.appendChild(square);
    field.appendChild(square2);

    let checker = document.createElement('img');
    checker.classList.add('black_checker');
    checker.src = 'img/black_checker.png';

    checker.addEventListener('dragstart', dragStart);

    square.appendChild(checker);
}

function dragStart(e) {
    console.log('dragStart ' + this);
}
