CREATE TABLE gamedata (
	gamenumber SERIAL PRIMARY KEY,
	gamewinner VARCHAR(15),
	numberrounds int,
	humanroundwins int,
    ai1wins int,
    ai2wins int,
    ai3wins int,
    ai4wins int,
	numberdraws int
)