google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);
desc = {};
function getSex() {
    jQuery.get("../v1/questionary/1/age").success(
            function (response) {
                desc = response;
                console.log(response[0].count);
            }
    );
}

function drawChart() {
    getSex();

    var data = google.visualization.arrayToDataTable([
        ['Idade', 'Número de Participantes'],
        ['Menos de 18 anos', desc[0].count],
        ['Entre 18 e 22 anos', desc[1].count],
        ['Entre 22 e 30 anos', desc[2].count],
        ['Entre 30 e 40 anos', desc[3].count],
        ['Entre 40 e 50 anos', desc[4].count]
    ]);

    var options = {
        title: 'Faixa etária'
    };

    var chart = new google.visualization.PieChart(document.getElementById('ageGraph'));

    chart.draw(data, options);
}
drawChart();