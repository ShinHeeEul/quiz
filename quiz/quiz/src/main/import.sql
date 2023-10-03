
insert into BigCategory(ID, name) values (0, '내 질문'), (1, '정신과'), (2, '신장');

LOAD DATA INFILE "category.tsv" INTO TABLE SmallCategory FIELDS TERMINATED BY "\t";

LOAD DATA INFILE "question.tsv" INTO TABLE Question FIELDS TERMINATED BY "\t";

