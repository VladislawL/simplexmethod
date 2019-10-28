<%@ page language="java" contentType="text/html"
    pageEncoding="utf-8"%>
<%
	String[] solution = request.getParameterValues("table[]");
	String[] function = request.getParameterValues("func[]");
%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp"></jsp:include>
<body>
	<div class="container h-100">
        <table style="width: 100%; height: 100%">
            <tr align="center">
                <td valign="center">
					<%
						if(solution != null) out.println(solution);
						out.println("");
						if(function != null) out.println(function);
					%>
                </td>
            </tr>
        </table>
    </div>
</body>
<jsp:include page="foot.jsp"></jsp:include>
</html>