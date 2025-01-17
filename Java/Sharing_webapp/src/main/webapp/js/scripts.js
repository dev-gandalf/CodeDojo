$(document).ready(function() {

	var privateStompClient = null;
	var receiver = null;
	var timestamp = $.now();


	function connect() {
		var socket = new SockJS('/gs-guide-websocket');
		privateStompClient = Stomp.over(socket);
		privateStompClient.connect({}, function(frame) {
			true;
			console.log('Connected: ' + frame);
			privateStompClient.subscribe('/user/specific', function(greeting) {
				receiver = JSON.parse(greeting.body).sender;
				if(receiver === $("#receiver").val()){
				showGreeting(JSON.parse(greeting.body).content);}
			});
		});
	}

	connect();



	function sendMessage() {
		privateStompClient.send("/app/private", {}, JSON.stringify({
			'message': $("#sender").val() + ":   " + $("#message").val(),
			'receiver': $("#receiver").val(), 'sender': $("#sender").val(), 'time': timestamp
		}));
	}


	function showGreeting(message) {
		$("#greetings").append("<br /><div>" + message + "</div>");
	}

	function showMessageToUserTwo() {
		$("#greetings").append("<br /><div>" + $("#sender").val() + ":   " + $("#message").val() + "</div>");
	}

function messageNotNull(){
	
	if($("#message").val().length > 0){
            
            sendMessage(); showMessageToUserTwo(); $("#message").val("");
        }
	
	
}

	$(function() {
		$("form").on('submit', function(e) {
			e.preventDefault();
		});
		$("#send").click(function() {messageNotNull(); });
	});

});