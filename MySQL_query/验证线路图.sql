SELECT line.name, station.name
FROM line
JOIN stationLine ON line.id = stationLine.lineId
JOIN station ON station.id = stationLine.stationId
WHERE line.name='2号线'
ORDER BY stationLine.sequence;

        SELECT s.id,s.name
        FROM station s
        INNER JOIN stationLine sl ON s.id = sl.stationId
        INNER JOIN line l ON l.id = sl.lineId
        WHERE l.name="2号线"
        ORDER BY sl.sequence;