
DROP TABLE IF EXISTS "books";
DROP TABLE IF EXISTS "authors"
DROP TABLE IF EXISTS "users"
DROP TABLE IF EXISTS "items"
DROP TABLE IF EXISTS "expenses"

CREATE TABLE  "authors" (
    "id" bigint  DEFAULT nextval('authors_id_seq') NOT NULL,
    "name" text,
    "age" integer,
    CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);


CREATE TABLE "books" (
    "isbn" text NOT NULL,
    "title" text,
    "author_id" bigint,
    CONSTRAINT "books_pk" PRIMARY KEY ("isbn"),
    CONSTRAINT "fk_author" FOREIGN KEY (author_id)
                     REFERENCES authors

);

CREATE TABLE "users" (
    "id"     bigint DEFAULT nextval('users_id_seq') NOT NULL,
    "name"   text,
    "user_name" text,
    "password"  text,
    CONSTRAINT "users_pk" PRIMARY KEY ("id")

);

CREATE TABLE "items" (
    "id"   bigint DEFAULT nextval('items_id_seq') NOT NULL,
    "name" text,
    "quantity" integer,
    "price" integer,
    CONSTRAINT "items_pk" PRIMARY KEY ("id")
);

CREATE TABLE "expenses" (
    "id" bigint DEFAULT nextval('expenses_id_seq') NOT NULL,
    "user_id" bigint,
    "item_id" bigint,
    CONSTRAINT "expenses_pk" PRIMARY KEY ("id")
    CONSTRAINT "fk_user" FOREIGN KEY(user_id) REFERENCES users,
    CONSTRAINT "fk_items" FOREIGN KEY (item_id) REFERENCES items
);