<!DOCTYPE html>
<%@page import="com.thera.thermfw.base.IniFile"%>
<%
String webAppPath = IniFile.getValue("thermfw.ini", "Web", "WebApplicationPath");
%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Firma Documento</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
        html, body {
            height: 100%;
            margin: 0;
        }
        .container-fluid {
            height: 100%;
        }
        .row {
            height: 100%;
        }
        .col-left {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        .col-right {
            height: 100%;
        }
        .pdf-viewer {
            width: 100%;
            height: 100%;
            border: none;
        }
    </style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-left">
			<h3>Firma qui</h3>
				<canvas id="signature-pad" width="500" height="300"
					style="border: 1px solid #000000;"></canvas>
				<button onclick="clearSignature()">Pulisci</button>
				<button onclick="saveSignature()">Salva</button>

			</div>
			<div class="col-md-8 col-right">
				<iframe class="pdf-viewer" id="pdfViewer" src="" frameborder="0"></iframe>
				<input type="hidden" id="chiaveDocumentoDigitale"></input>
			</div>
		</div>
	</div>

	<script>
        $(document).ready(function() {
            fetchDocument();
        });

        function fetchDocument() {
            $.ajax({
            	url: getURLWS() + '/firmaDigitale/documenti/attesaFirma/recupera',
                method: 'GET',
                dataType: 'json',
                success: function(data) {
                	 var base64PDF = data.file;
                     var chiaveDocumentoDigitale = data.info;
					 $('#chiaveDocumentoDigitale').val(chiaveDocumentoDigitale);
                     var pdfDataUrl = 'data:application/pdf;base64,' + base64PDF;
                     $('#pdfViewer').attr('src', pdfDataUrl);
                },
                error: function(err) {
                    $('#pdfViewer').replaceWith('<p>Error loading document.</p>');
                    console.error('Error fetching document:', err);
                }
            });
        }
        
        function getURLWS() {
        	var ris;
        	var url = window.location.href;
        	var cut = url.indexOf("<%=webAppPath%>");
        	ris = url.substring(0, cut);
        	ris += "<%=webAppPath%>";
        	ris += "/api";
        	return ris;
        }

        var canvas = document.getElementById('signature-pad');
        var ctx = canvas.getContext('2d');
        var drawing = false;

        // Function to get the mouse or touch position relative to the canvas
        function getPosition(event) {
	        var rect = canvas.getBoundingClientRect();
	        var x, y;
	        if (event.touches) {
		        x = event.touches[0].clientX - rect.left;
		        y = event.touches[0].clientY - rect.top;
	        } else {
		        x = event.clientX - rect.left;
		        y = event.clientY - rect.top;
        	}
        	return {x: x, y: y};
        }

        // Start drawing
        function startDrawing(event) {
        	drawing = true;
        	var position = getPosition(event);
        	ctx.moveTo(position.x, position.y);
        }

        // Draw on the canvas
        function draw(event) {
        	if (drawing) {
        		var position = getPosition(event);
        		ctx.lineTo(position.x, position.y);
        		ctx.stroke();
        	}
        }

        // Stop drawing
        function stopDrawing() {
        	drawing = false;
        }

        // Event listeners for mouse events
        canvas.addEventListener('mousedown', startDrawing);
        canvas.addEventListener('mousemove', draw);
        canvas.addEventListener('mouseup', stopDrawing);
        canvas.addEventListener('mouseout', stopDrawing);

        // Event listeners for touch events
        canvas.addEventListener('touchstart', function(event) {
        	event.preventDefault(); // Prevent scrolling when touching the canvas
        	startDrawing(event);
        });
        canvas.addEventListener('touchmove', function(event) {
        	event.preventDefault(); // Prevent scrolling when touching the canvas
        	draw(event);
        });
        
        canvas.addEventListener('touchend', stopDrawing);
        canvas.addEventListener('touchcancel', stopDrawing);

        // Clear the canvas
        function clearSignature() {
     	   ctx.clearRect(0, 0, canvas.width, canvas.height);
        }

        // Save the signature
        function saveSignature() {
        	var canvas = document.getElementById('signature-pad');
            var chiaveDocumentoDigitale = $('#chiaveDocumentoDigitale').val();
            var signatureDataUrl = canvas.toDataURL('image/png');
            
            var requestData = {
                documentId: chiaveDocumentoDigitale,
                signature: signatureDataUrl
            };

            $.ajax({
                url: getURLWS() + '/firmaDigitale/documenti/attesaFirma/firma',
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(requestData),
                success: function(response) {
                    alert('Signature saved successfully');
                },
                error: function(err) {
                    console.error('Error saving signature:', err);
                    alert('Error saving signature');
                }
            });
        }
    </script>
</body>
</html>
