
insert into BigCategory(ID, name) values (1, '정신과'), (2, '신장');

LOAD DATA INFILE "category.tsv" INTO TABLE SmallCategory FiELDS TERMINATED BY "\t";

LOAD DATA INFILE "question.tsv" INTO TABLE Question FiELDS TERMINATED BY "\t";

