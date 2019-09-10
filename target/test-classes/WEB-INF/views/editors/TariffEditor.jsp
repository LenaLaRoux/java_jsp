<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="editor">
    <form id="frmId">
        <fieldset form="frmId">
            <legend>Тариф</legend>
            <div class="prop-wrapper">
            <div>
                <label for="tariffType">Тип тарифа: <em>*</em></label>
                <select id="tariffType" form="frmId" required>
                    <option>По типу недв-сти</option>
                    <option>По площади</option>
                    <option>По дате постройки</option>
                </select>
            </div>
            <div>
                <label for="buildyearto"> Построено c: </label>
                <input type="date" id="buildyearfrom" >
            </div>
            <div>
                <label for="buildyearto"> Построено до: </label>
                <input type="date" id="buildyearto">
            </div>
            <div>
                <label for="squarefrom"> Площадь (м3) с: </label>
                <input type="number" id="squarefrom" value="54">
            </div>
            <div>
                <label for="squareto"> Площадь (м3) до: </label>
                <input type="number" id="squareto">
            </div>
            <div>
                <label for="propertytype"> Тип недв-сти </label>
                <select id="propertytype" form="frmId">
                    <option>Дом</option>
                    <option>Хозблок</option>
                    <option>Квартира</option>
                </select>
            </div>
            <div><label for="value">Премия</label><input type="number" id="value"></div>
            <div>
                <label for="versionfrom">Версия активна с: </label>
                <input type="date" id="versionfrom" >
            </div>
            <div>
                <label for="versionto"> Версия активна до: </label>
                <input type="date" id="versionto">
            </div>
            </div>
        </fieldset>
    </form>

</div>
