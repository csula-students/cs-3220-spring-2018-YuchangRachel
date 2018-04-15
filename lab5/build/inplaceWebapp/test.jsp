<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<body>

    <div class="row">
        <form class="form-inline" action="/test">
            <div class="form-group">
                <label class="label-middle">开始时间</label><input size="16" type="text" value="${startTime}" name="startTime">
                <label class="label-middle">结束时间</label><input size="16" type="text" value="${endTime}" name="endTime">
                &nbsp; <button type="submit">查询</button>
            </div>
        </form>
    </div>

    <div class="row margin-top-20">
        <table class="table">
            <thead>
            <tr>
                <th class="seq">序号</th>
                <th>时间</th>
                <th>MSG</th>
            </tr>
			</thead>
            <tbody>
            </tbody>
            <c:forEach var="data" items="${datas}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${data.time}</td>
                    <td>${data.msg}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
