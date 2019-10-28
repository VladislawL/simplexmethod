<%@ page language="java" contentType="text/html"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body>
    <div class="container h-100">
        
        <table style="width: 100%; height: 100%">
            <tr align="center">
                <td valign="center">
                    <form method="GET" name="form" action="simplexTable">
                        <div class="list">
                            <input id="x" name="m" type="text" class="form-control input">
                            <input id="limit" name="n" type="text" class="form-control input">
                        </div>
                        <button>Далее</button>
                    </form>
                </td>
            </tr>
        </table>
    </div>
</body>
<jsp:include page="foot.jsp"></jsp:include>
</html>
