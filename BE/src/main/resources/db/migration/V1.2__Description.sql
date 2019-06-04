
CREATE TABLE IF NOT EXISTS business_owner(

  id serial PRIMARY KEY ,
  username VARCHAR(64) NOT NULL,
  password VARCHAR (64) NOT NULL

);


CREATE TABLE IF NOT EXISTS investor(

  id serial PRIMARY KEY,
  username VARCHAR(64) NOT NULL,
  password VARCHAR (64) NOT NULL,
  capital REAL
);

CREATE TABLE IF NOT EXISTS company(
  id serial PRIMARY KEY,
  ownerId INT NOT NULL REFERENCES business_owner(id) ON DELETE CASCADE ON UPDATE CASCADE,
  companyName VARCHAR(64) NOT NULL,
  companyTag VARCHAR(64) NOT NULL,
  shares INT,
  sharePrice REAL,
  splitFactor VARCHAR (64) NOT NULL
);


CREATE TABLE IF NOT EXISTS transactions(
  id serial PRIMARY KEY,
  investorId INT NOT NULL REFERENCES investor(id) ON DELETE CASCADE ON UPDATE CASCADE,
  companyId INT NOT NULL REFERENCES company(id) ON DELETE CASCADE ON UPDATE CASCADE,
  kind VARCHAR(64),
  stockNumber int NOT NULL,
  stockPrice REAL NOT NULL,
  creationDate TIME NOT NULL
);

CREATE TABLE IF NOT EXISTS owned_stocks(
  id serial PRIMARY KEY ,
  investorId INT NOT NULL REFERENCES investor(id) ON DELETE CASCADE ON UPDATE CASCADE,
  companyId INT NOT NULL REFERENCES company(id) ON DELETE CASCADE ON UPDATE CASCADE,
  stockNumber INT,
  stockPrice REAL

);

