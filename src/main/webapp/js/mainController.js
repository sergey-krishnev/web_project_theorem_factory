let mainApp = angular.module('mainApp', []);
let functor_id;
let relation_id;
let class_id;
let tmodel_id;
let functor_entity;
let relation_entity;
let class_entity;
let tmodel_entity;
mainApp.controller('FunctorCtrl', function ($scope, $http){
    $http.get(location.href + 'functors').success(function(data) {
        $scope.functors = data;
    });
});

mainApp.controller('RelationCtrl', function ($scope, $http) {
    $http.get(location.href + 'relations').success(function(data) {
        $scope.relations = data;
    });
});

mainApp.controller('ClassCtrl', function ($scope, $http) {
    $http.get(location.href + 'classes').success(function(data) {
        $scope.classes = data;
    });
});

mainApp.controller('TmodelCtrl', function ($scope, $http) {
    $http.get(location.href + 'tmodels').success(function(data) {
        $scope.tmodels = data;
    });
});

function checkFunctor(entity) {
    event.preventDefault();
    document.getElementById("FunctorDropdown").classList.remove("show");
    functor_id = entity.getAttribute("href");
    loadJSON(location.href + 'functors/' + functor_id,
        function(data) { console.log(data.functorProperties[0]);
            functor_entity = data;
            let html = '';
            let renderName = katex.renderToString(data.name, {
                throwOnError: false
            });
            html +='<li><b>Name:</b> <div lang="latex">'+ renderName +'</div></li>';
            html +='<li><b>Description:</b> '+ data.description +' </li>';
            html +='<li><b>Properties:</b></li>';
            html +='<li>';
            for(let i=0; i<data.functorProperties.length; i++) {
                  html += ' ' + data.functorProperties[i].name + ' '
            }
            html +='</li>';
            document.getElementById('functor-information').innerHTML = html;
                },
        function(xhr) { console.error(xhr); }
    );

}

function checkRelation(entity) {
    event.preventDefault();
    document.getElementById("RelationDropdown").classList.remove("show");
    relation_id = entity.getAttribute("href");
    loadJSON(location.href + 'relations/' + relation_id,
        function(data) { console.log(data.relationProperties[0]);
            relation_entity = data;
            let html = '';
            let renderName = katex.renderToString(data.name, {
                throwOnError: false
            });
            let renderDescription = renderOddPartly(data.description);
            html +='<li><b>Name:</b> <div lang="latex">'+ renderName +'</div></li>';
            html +='<li><b>Description:</b> '+ renderDescription +' </li>';
            html +='<li><b>Properties:</b></li>';
            html +='<li>';
            for(let i=0; i<data.relationProperties.length; i++) {
                html += ' ' + data.relationProperties[i].name + ' '
            }
            html +='</li>';
            document.getElementById('relation-information').innerHTML = html;
        },
        function(xhr) { console.error(xhr); }
    );

}

function checkClass(entity) {
    event.preventDefault();
    document.getElementById("ClassDropdown").classList.remove("show");
    class_id = entity.getAttribute("href");
    loadJSON(location.href + 'classes/' + class_id,
        function(data) { console.log(data.classProperties[0]);
            class_entity = data;
            let html = '';
            let renderName = katex.renderToString(data.name, {
                throwOnError: false
            });
            html +='<li><b>Name:</b> <div lang="latex">'+ renderName +'</div></li>';
            html +='<li><b>Description:</b> '+ data.description +' </li>';
            html +='<li><b>Properties:</b></li>';
            html +='<li>';
            for(let i=0; i<data.classProperties.length; i++) {
                html += ' ' + data.classProperties[i].name + ' '
            }
            html +='</li>';
            document.getElementById('class-information').innerHTML = html;
        },
        function(xhr) { console.error(xhr); }
    );

}

function checkTModel(entity) {
    event.preventDefault();
    document.getElementById("TmodelDropdown").classList.remove("show");
    tmodel_id = entity.getAttribute("href");
    loadJSON(location.href + 'tmodels/' + tmodel_id,
        function(data) { console.log(data);
            tmodel_entity = data;
            let html = '';
            let renderName = katex.renderToString(data.name, {
                throwOnError: false
            });
            html +='<li><b>Name:</b> <div lang="latex">'+ renderName +'</div></li>';
            html +='<li><b>Functor properties:</b></li>';
            html +='<li>';
            for(let i=0; i<data.functorProperties.length; i++) {
                html += ' ' + data.functorProperties[i].name + ' '
            }
            html +='</li>';
            html +='<li><b>Relation properties:</b></li>';
            html +='<li>';
            for(let i=0; i<data.relationProperties.length; i++) {
                html += ' ' + data.relationProperties[i].name + ' '
            }
            html +='</li>';
            html +='<li><b>Class properties:</b></li>';
            html +='<li>';
            for(let i=0; i<data.classProperties.length; i++) {
                html += ' ' + data.classProperties[i].name + ' '
            }
            html +='</li>';
            document.getElementById('tmodel-information').innerHTML = html;
        },
        function(xhr) { console.error(xhr); }
    );
}

function generateTemplate() {
    let html = '';
    for (let i = 0; i < tmodel_entity.templates.length; i++) {
        html += '<h3>' + tmodel_entity.templates[i].name + '</h3>';

        let substitute_content = substitute(tmodel_entity.templates[i].content);

        let renderContent = renderOddPartly(substitute_content);

        html += '<p>' + renderContent + '</p>';
        html += '<hr>';
    }
    document.getElementById('generated-file-preview').innerHTML = html;
}

function substitute(content) {

    let substitute_functor = content.split("NameSpecificFunctor").join(functor_entity.name);
    return substitute_functor.split("NameSpecificRelation").join(relation_entity.name);;

}

function renderOddPartly(content) {
    let arrStr = content.split(/[$]/);
    for (let i = 1; i < arrStr.length; i+=2) {
        let renderContent = katex.renderToString(arrStr[i], {
            throwOnError: false
        });
        arrStr[i] = renderContent;
    }
    return arrStr.join(" ");

}

function renderEvenPartly(content) {
    let arrStr = content.split(/[$]/);
    for (let i = 0; i < arrStr.length; i+=2) {
        let renderContent = katex.renderToString(arrStr[i], {
            throwOnError: false
        });
        arrStr[i] = renderContent;
    }
    return arrStr.join(" ");
}


function loadJSON(path, success, error) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                if (success)
                    success(JSON.parse(xhr.responseText));
            } else {
                if (error)
                    error(xhr);
            }
        }
    };
    xhr.open("GET", path, true);
    xhr.send();
}

