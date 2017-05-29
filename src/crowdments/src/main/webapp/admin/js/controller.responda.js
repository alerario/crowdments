google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);
sex = {};
masc = 0;
fem = 0;

function getSex() {
    jQuery.get("../v1/questionary/1/sex").success(
            function (response) {
                sex = response;
                masc = sex[0].count;
                fem = sex[1].count;
            }
    );
}

function drawChart() {
    getSex();

    var data = google.visualization.arrayToDataTable([
        ['Sexo', 'Quantidade'],
        ['Masculino', masc],
        ['Feminino', fem]
    ]);

    var options = {
        title: 'Sexo'
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

    chart.draw(data, options);
}
drawChart();