<%@ page language="java" contentType="text/html"
    pageEncoding="utf-8"%>
<%
	int n = Integer.parseInt(request.getParameter("n"));
	int m = Integer.parseInt(request.getParameter("m"));
%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp"></jsp:include>
<body>
	<div class="container h-100">
        <button id="back">Назад</button>
        <table style="width: 100%; height: 100%">
            <tr align="center">
                <td valign="center">
                	<form method="GET" action="solution">
                		<div class="blackboard">
		                    <table id="table" style="margin-bottom: 2em">
								<%
									for(int i = 0; i < n; i++){
										out.println("<tr> ");
										for(int j = 0; j < m; j++) {
											out.println("<td><input name=\"" + i+j + "\" type=\"text\" class=\"form-control input\"></td>");
										}
										out.println("<td>" +  
										          		"<select name='condition" + i + "'>" +
										            		"<option value='1'>&le;</option>" +
										            		"<option value='-1'>&ge;</option>" +
										          		"</select>" +
										        	"</td>" +
										        	"<td><input name=\"b" + i + "\" type=\"text\" class=\"form-control input\"></td>" +
										          	"</tr>");
									}
								%>
		                    </table>
		                    <table id="function" style="margin-bottom: 2em">
		                    	<tr>
		                    	<%
									for(int i = 0; i < m; i++) {
										out.println("<td><input name=\"f" + i + "\" type=\"text\" class=\"form-control input\"></td>");
									}
		                    	out.println("<td>" +  
						          		"<select name='maxmin'>" +
						            		"<option value='1'>max</option>" +
						            		"<option value='-1'>min</option>" +
						          		"</select>" +
						        	"</td>");
								%>
								</tr>
		                    </table>
	                    </div>
	                    <button>Решить</button>
                    </form>
                </td>
            </tr>
        </table>
    </div>
</body>
<jsp:include page="foot.jsp"></jsp:include>
<script>

	$("#back").click(function () {
		$.ajax({
			  url: "simplexInput",
			  type: "GET",
			  success: function() {
				  location.href = 'simplexInput';
			  }
		});
	});
	
	/*$("#solve").click(function () {
		$.ajax({
			  url: "solution",
			  type: "GET",
			  dataType:'json',
			  data: {
				  table: readTable(),
				  func: readFunc()
				  },
			  complete: function() {
				  location.href = "solution";
			  }
		});
	});
	
	function readTable() {
		var table = [];
		var i = 0;
		console.log("readTable");
		$('#table tr').each(function(){
		    $(this).find('td').each(function(){
		        if(Math.abs($(this).children()[0].value)) {		        	
		        	table[i++] = Number($(this).children()[0].value);
		        } else {
		        	var e = $(this).children()[0];
		        	table[i++] = Number(e.options[e.selectedIndex].value);
		        }
		    });
		});
		console.log(table);
		return table;
	}
	
	function readFunc() {
		var func = [];
		var i = 0;
		$('#function tr').each(function(){
		    $(this).find('td').each(function(){
		        //do your stuff, you can use $(this) to get current cell
		        if(Math.abs($(this).children()[0].value)) {		        	
		        	func[i++] = Number($(this).children()[0].value);
		        } else {
		        	var e = $(this).children()[0];
		        	func[i++] = Number(e.options[e.selectedIndex].value);
		        }
		    });
		});
		console.log(func);
		return func;
	}*/
</script>
</html>