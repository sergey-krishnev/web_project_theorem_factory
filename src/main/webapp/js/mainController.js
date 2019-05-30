var mainApp = angular.module('mainApp', []);
var id;
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
    id = entity.getAttribute("href");
    loadJSON(location.href + 'functors/' + id,
        function(data) { console.log(data.functorProperties[0]);
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
    id = entity.getAttribute("href");
    loadJSON(location.href + 'relations/' + id,
        function(data) { console.log(data.relationProperties[0]);
            let html = '';
            let renderName = katex.renderToString(data.name, {
                throwOnError: false
            });
            let renderDescription = katex.renderToString(data.description, {
                throwOnError: false
            });
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
    id = entity.getAttribute("href");
    loadJSON(location.href + 'classes/' + id,
        function(data) { console.log(data.classProperties[0]);
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

