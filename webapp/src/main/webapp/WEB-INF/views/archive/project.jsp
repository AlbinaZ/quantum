<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="project" type="java.util.List<ru.kpfu.quantum.spring.entities.Project>"--%>


<div id="project-area" class="project container">


    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">${project.name}</h3>
        </div>
        <div class="panel-body">
            <p>Дата создания: ${project.created}</p>
            <p>Дата последнего изменения: ${project.lastModified}</p>
            <div class="panel panel-default">
                <div class="panel-body">
                    ${project.code}
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <img src="/media/${project.id}.png"/>
                </div>
            </div>

            <div class="well"><p>${project.description}</p></div>

            <p><a download class="btn btn-primary btn-lg" href="/media/${project.id}.png">Скачать</a></p>

        </div>
    </div>


</div>

