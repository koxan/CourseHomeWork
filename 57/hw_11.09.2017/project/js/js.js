$(document).ready(function () {
    $(':button:first').click(function () {
        $('.red, ul').css('color', 'red');
    });

    $(':button:eq(1)').click(function () {
        $('div p').css('color', 'blue');
    });

    $(':button:eq(2)').click(function () {
        $('p:has(img) strong').css('font-style', 'italic');
    });

    $(':button:last').click(function () {
        let red = parseInt(Math.random() * 256);
        let green = parseInt(Math.random() * 256);
        let blue = parseInt(Math.random() * 256);
        let rgb = 'rgb(' + red + ',' + green + ',' + blue + ')';
        $('.blocks div').css('background', rgb);
    });
});
