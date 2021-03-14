INSERT INTO ChessPlayer(id, birthDate, firstName, lastName, version) VALUES (1, '1921-03-24', 'Wassili', 'Smyslow', 0);
INSERT INTO ChessPlayer(id, birthDate, firstName, lastName, version) VALUES (2, '1924-02-19', 'Dawid', 'Bronstein', 0);
INSERT INTO ChessPlayer(id, birthDate, firstName, lastName, version) VALUES (3, '1916-01-07', 'Paul', 'Keres', 0);

INSERT INTO ChessTournament(id, DTYPE, startDate, endDate, name, numPlayers, version) VALUES (1, 'RoundRobin', '1953-08-29', '1953-10-24', 'Zurich international chess tournament', 15, 0);

INSERT INTO ChessGame(id, round, version, chessTournament_id, playerBlack_id, playerWhite_id) VALUES (1, 1, 0, 1, 1, 2);
INSERT INTO ChessGame(id, round, version, chessTournament_id, playerBlack_id, playerWhite_id) VALUES (2, 2, 0, 1, 1, 3);
INSERT INTO ChessGame(id, round, version, chessTournament_id, playerBlack_id, playerWhite_id) VALUES (3, 3, 0, 1, 2, 3);