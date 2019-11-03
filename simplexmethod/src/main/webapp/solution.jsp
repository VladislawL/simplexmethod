<%@ page language="java" contentType="text/html"
    pageEncoding="utf-8"%>
<%
	double[][] optimalTable = (double[][])request.getSession().getAttribute("optimalTable");
	Object[] basisVariables = (Object[])request.getSession().getAttribute("basisVariables");
	int n = (int)request.getSession().getAttribute("n") + 1;
	int m = (int)request.getSession().getAttribute("m") + n - 1;
%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp"></jsp:include>
<body>
	<div class="container h-100">
        <table style="width: 100%; height: 100%">
            <tr align="center">
                <td valign="center">
                	<div class="blackboard">
						<table id="table" class="table table-bordered" style="margin-bottom: 2em">
							<%
								out.println("<tr><th>Б.П.</th><th>Б.К.</th>");
								for(int i = 1; i < m; i++) 
									out.println("<th>" + "x" + i + "</th>");
								out.println("</tr>");
								for(int i = 0; i < n; i++){
									out.println("<tr> ");
									if(i != n - 1)
										out.println("<td>" + "x" + (Integer)basisVariables[i] + "</td>");
									else out.println("<td>" + "f" + "</td>");
									for(int j = 0; j < m; j++) {
										out.println("<td>" + optimalTable[i][j] + "</td>");
									}
									out.println("</tr>");
								}
							%>
	                    </table>
					</div>	                   
                </td>
            </tr>
        </table>
    </div>
</body>
<jsp:include page="foot.jsp"></jsp:include>
</html>