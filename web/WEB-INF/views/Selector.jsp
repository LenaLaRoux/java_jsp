<%@ page import="Utils.ColumnEditor.ValEditorFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <div class="selector" >
        <table>
            <c:forEach var="title" items="${titles}" >
                <th>
                    <c:out value="${title.title}" />
                </th>
            </c:forEach>
            <c:forEach var="model" items="${models}" >
                <tr id = "${model.getId()}" ondblclick="popupEditor('${model.getId()}')">
                    <c:forEach var="column" items="${model.getSelectorColumns()}">
                        <td><c:out value="${column.valueToString()}" /></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>

        <div class="popup" style="visibility: hidden">
            <div class='popup-content' id='popup'>
                <div class='header'></div>
                <div class='body'>я кукорача</div>
                <div class='footer'>
                    <button onclick="popUpClose()" id='close-button'>Close</button>
                </div>
            </div>
        </div>
    </div>
