CREATE TABLE Item (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  name                VARCHAR(255) NOT NULL,
  description         VARCHAR(255),
  price               DOUBLE NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT UC_Item_name UNIQUE(name)
);

CREATE TABLE OrderPosition (
	orderId				BIGINT NOT NULL,
	itemId				BIGINT NOT NULL
);

CREATE TABLE Customer (
	id					BIGINT NOT NULL AUTO_INCREMENT,
	modificationCounter	INTEGER NOT NULL,
	firstname			VARCHAR(255),
	lastname			VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE OrderSummary (
	id					BIGINT NOT NULL AUTO_INCREMENT,
	modificationCounter INTEGER NOT NULL,
	price				DOUBLE,
	ownerId				BIGINT NOT NULL,
	creationDate		DATE NOT NULL,
	status				VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

ALTER TABLE OrderSummary
	ADD FOREIGN KEY(ownerId) REFERENCES Customer(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE OrderPosition
	ADD FOREIGN KEY(orderId) REFERENCES OrderSummary(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE OrderPosition
	ADD FOREIGN KEY(itemId) REFERENCES Item(id) ON DELETE CASCADE ON UPDATE CASCADE;
