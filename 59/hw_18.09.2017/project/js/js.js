let slideSpeed = 'normal';

$(document).ready(function () {
    // выпадающее меню
    $('.dropbtn')
        .click(function () {
        $('#myDropdown')
            .slideToggle(slideSpeed)
            .find('a')
            .click(function () {
                $(this).parent().slideUp(slideSpeed);
                // вопрос по slideToggle
                // $(this).parent().slideToggle(slideSpeed);
            });
    });

    $('h3:first').addClass('active').next().css('display', 'block');

    // аккордеон
    $('#accordion h3').click(function () {
        if ($(this).hasClass('active')) {
            accordUp(this);
        } else {
            $(this).addClass('active');
            $(this).next().slideDown(slideSpeed);
            accordUp($('.active').not(this));
        }
    });

    // функция для аккордеона
    function accordUp(elem) {
        $(elem)
            .removeClass('active')
            .next().slideUp(slideSpeed);
    }
});