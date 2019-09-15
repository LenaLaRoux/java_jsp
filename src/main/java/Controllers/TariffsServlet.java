package Controllers;

import Entities.TariffEntity;
import EntityGroups.ContractGroup;
import EntityGroups.ModelGroup;
import EntityGroups.TariffGroup;
import Utils.Meta;
import jdk.nashorn.internal.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TariffsServlet", urlPatterns = { "/Tariffs"})
public class TariffsServlet extends IndexServlet {
    @Override
    protected ModelGroup defineGroup (){
        return new TariffGroup();
    }

    @Override
    protected String defineRequestUrl (){
        return "/";
    }

   /* @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String modelIndex = request.getParameter("index");
        if (modelIndex != null){
            TariffEntity tariff = this.group.getById(Integer.valueOf(modelIndex));
            response.getWriter().print(tariff.toHtml());
        }else
            super.doGet(request, response);
    }*/

    /*private String htmlEditorForm(){
        String result = "<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>\n" +
                "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>\n"+
                "<div class=\"editor\">\n" +
                "    <form id=\"frmId\">\n" +
                "        <fieldset form=\"frmId\">\n" +
                "            <legend>Тариф</legend>\n" +
                "            <div class=\"prop-wrapper\">\n" +
                "            <div>\n" +
                "                <label for=\"tariffType\">Тип тарифа: <em>*</em></label>\n" +
                "                <select id=\"tariffType\" form=\"frmId\" required>\n" +
                "                    <option>По типу недв-сти</option>\n" +
                "                    <option>По площади</option>\n" +
                "                    <option>По дате постройки</option>\n" +
                "                </select>\n" +
                "            </div>\n" +
                "            <div>\n" +
                "                <label for=\"buildyearto\"> Построено c: </label>\n" +
                "                <input type=\"date\" id=\"buildyearfrom\" >\n" +
                "            </div>\n" +
                "            <div>\n" +
                "                <label for=\"buildyearto\"> Построено до: </label>\n" +
                "                <input type=\"date\" id=\"buildyearto\">\n" +
                "            </div>\n" +
                "            <div>\n" +
                "                <label for=\"squarefrom\"> Площадь (м3) с: </label>\n" +
                "                <input type=\"number\" id=\"squarefrom\" value=\"54\">\n" +
                "            </div>\n" +
                "            <div>\n" +
                "                <label for=\"squareto\"> Площадь (м3) до: </label>\n" +
                "                <input type=\"number\" id=\"squareto\">\n" +
                "            </div>\n" +
                "            <div>\n" +
                "                <label for=\"propertytype\"> Тип недв-сти </label>\n" +
                "                <select id=\"propertytype\" form=\"frmId\">\n" +
                "                    <option>Дом</option>\n" +
                "                    <option>Хозблок</option>\n" +
                "                    <option>Квартира</option>\n" +
                "                </select>\n" +
                "            </div>\n" +
                "            <div><label for=\"value\">Премия</label><input type=\"number\" id=\"value\"></div>\n" +
                "            <div>\n" +
                "                <label for=\"versionfrom\">Версия активна с: </label>\n" +
                "                <input type=\"date\" id=\"versionfrom\" >\n" +
                "            </div>\n" +
                "            <div>\n" +
                "                <label for=\"versionto\"> Версия активна до: </label>\n" +
                "                <input type=\"date\" id=\"versionto\">\n" +
                "            </div>\n" +
                "            </div>\n" +
                "        </fieldset>\n" +
                "    </form>\n" +
                "\n" +
                "</div>";
        return result;
    }*/


}
