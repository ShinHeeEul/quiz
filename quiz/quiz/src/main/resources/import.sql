
insert into BigCategory(ID, name) values (0, '내 질문'), (1, '정신과'), (2, '신장');

LOAD DATA INFILE "category.tsv" INTO TABLE SmallCategory FIELDS TERMINATED BY "\t" (big_category_id,name);

LOAD DATA INFILE "question.tsv" INTO TABLE Question FIELDS TERMINATED BY "\t" (small_category_id,code,num,question,selection,solution);

