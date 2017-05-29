google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);
desc = {};
function getSex() {
    jQuery.get("../v1/tag/tags/stats").success(
            function (response) {
                desc = response;
            }
    );
}

function drawChart() {
    getSex();

    var data = google.visualization.arrayToDataTable([
        ['Descrição', 'Quantidade'],
        [desc[0].description, desc[0].count],
        [desc[1].description, desc[1].count],
        [desc[2].description, desc[2].count],
        [desc[3].description, desc[3].count],
        [desc[4].description, desc[4].count],
        [desc[5].description, desc[5].count],
        [desc[6].description, desc[6].count],
        [desc[7].description, desc[7].count],
        [desc[8].description, desc[8].count],
        [desc[9].description, desc[9].count],
        [desc[10].description, desc[10].count],
        [desc[11].description, desc[11].count],
        [desc[12].description, desc[12].count],
        [desc[13].description, desc[13].count],
        [desc[14].description, desc[14].count],
        [desc[15].description, desc[15].count],
        [desc[16].description, desc[16].count]
    ]);

    var options = {
        title: 'Padrões de resposta (tags)'
    };

    var chart = new google.visualization.PieChart(document.getElementById('tagsGraph'));

    chart.draw(data, options);
}
drawChart();