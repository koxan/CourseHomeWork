$(function(){
    var webSocket;
    var log = $("#out");

    function init() {
        webSocket = new WebSocket("ws://localhost:8080/chat");

        $(webSocket).on("open", function () {
            log.text("Connection successfully\n");
        });

        $(webSocket).on("message", function (e) {
            var data = e.originalEvent.data;
            log.append("Server answered "+ data + " \n");
        });

        $(webSocket).on("error", function (err) {
            console.dir(err);
            log.append("Error messasge: " + err + "  <br/>");
        });

        $(webSocket).on("close", function () {
            log.append("Connection closed \n");
        });
    }

    $("#connect").click(function () {
        if($(this).text() == "Connect") {
            try {
                init();
                $(this).text("Disconnect");
            } catch(err) {
              console.log(err);
            }
        } else {
            if(webSocket) {
                webSocket.close();
                $(this).text("Connect");
            }
        }
    });

    $("#submit").click(function () {
        if(webSocket) {
            let msg = $("#message").val();
            webSocket.send(msg);
        }
    });
});