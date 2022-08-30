-- 브랜드
INSERT INTO brand (name) VALUES ('A');
INSERT INTO brand (name) VALUES ('B');
INSERT INTO brand (name) VALUES ('C');
INSERT INTO brand (name) VALUES ('D');
INSERT INTO brand (name) VALUES ('E');
INSERT INTO brand (name) VALUES ('F');
INSERT INTO brand (name) VALUES ('G');
INSERT INTO brand (name) VALUES ('H');
INSERT INTO brand (name) VALUES ('I');

-- 카테고리
INSERT INTO category (name) VALUES ('상의');
INSERT INTO category (name) VALUES ('아우터');
INSERT INTO category (name) VALUES ('바지');
INSERT INTO category (name) VALUES ('스니커즈');
INSERT INTO category (name) VALUES ('가방');
INSERT INTO category (name) VALUES ('모자');
INSERT INTO category (name) VALUES ('양말');
INSERT INTO category (name) VALUES ('액세서리');

-- 제품

-- A 브랜드 제품
INSERT INTO product (name, price, brand_id, category_id) VALUES ('a_상의', 11200, 1, 1);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('a_아우터', 5500, 1, 2);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('a_바지', 4200, 1, 3);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('a_스니커즈', 9000, 1, 4);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('a_가방', 2000, 1, 5);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('a_모자', 1700, 1, 6);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('a_양말', 1800, 1, 7);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('a_액세서리', 2300, 1, 8);

-- B 브랜드 제품
INSERT INTO product (name, price, brand_id, category_id) VALUES ('b_상의', 10500, 2, 1);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('b_아우터', 5900, 2, 2);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('b_바지', 3800, 2, 3);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('b_스니커즈', 9100, 2, 4);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('b_가방', 2100, 2, 5);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('b_모자', 2000, 2, 6);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('b_양말', 2000, 2, 7);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('b_액세서리', 2200, 2, 8);

-- C 브랜드 제품
INSERT INTO product (name, price, brand_id, category_id) VALUES ('c_상의', 10000, 3, 1);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('c_아우터', 6200, 3, 2);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('c_바지', 3300, 3, 3);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('c_스니커즈', 9200, 3, 4);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('c_가방', 2200, 3, 5);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('c_모자', 1900, 3, 6);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('c_양말', 2200, 3, 7);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('c_액세서리', 2100, 3, 8);


-- D 브랜드 제품
INSERT INTO product (name, price, brand_id, category_id) VALUES ('d_상의', 10100, 4, 1);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('d_아우터', 5100, 4, 2);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('d_바지', 3000, 4, 3);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('d_스니커즈', 9500, 4, 4);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('d_가방', 2500, 4, 5);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('d_모자', 1500, 4, 6);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('d_양말', 2400, 4, 7);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('d_액세서리', 2000, 4, 8);

-- E 브랜드 제품
INSERT INTO product (name, price, brand_id, category_id) VALUES ('e_상의', 10700, 5, 1);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('e_아우터', 5000, 5, 2);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('e_바지', 3800, 5, 3);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('e_스니커즈', 9900, 5, 4);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('e_가방', 2300, 5, 5);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('e_모자', 1800, 5, 6);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('e_양말', 2100, 5, 7);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('e_액세서리', 2100, 5, 8);

-- F product
INSERT INTO product (name, price, brand_id, category_id) VALUES ('f_상의', 11200, 6, 1);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('f_아우터', 7200, 6, 2);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('f_바지', 4000, 6, 3);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('f_스니커즈', 9300, 6, 4);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('f_가방', 2100, 6, 5);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('f_모자', 1600, 6, 6);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('f_양말', 2300, 6, 7);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('f_액세서리', 1900, 6, 8);

-- G 브랜드 제품
INSERT INTO product (name, price, brand_id, category_id) VALUES ('g_상의', 10500, 7, 1);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('g_아우터', 5800, 7, 2);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('g_바지', 3900, 7, 3);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('g_스니커즈', 9000, 7, 4);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('g_가방', 2200, 7, 5);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('g_모자', 1700, 7, 6);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('g_양말', 2100, 7, 7);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('g_액세서리', 2000, 7, 8);

-- H 브랜드 제품
INSERT INTO product (name, price, brand_id, category_id) VALUES ('h_상의', 10800, 8, 1);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('h_아우터', 6300, 8, 2);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('h_바지', 3100, 8, 3);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('h_스니커즈', 9700, 8, 4);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('h_가방', 2100, 8, 5);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('h_모자', 1600, 8, 6);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('h_양말', 2000, 8, 7);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('h_액세서리', 2000, 8, 8);

-- I 브랜드 제품
INSERT INTO product (name, price, brand_id, category_id) VALUES ('i_상의', 11400, 9, 1);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('i_아우터', 6700, 9, 2);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('i_바지', 3200, 9, 3);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('i_스니커즈', 9500, 9, 4);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('i_가방', 2400, 9, 5);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('i_모자', 1700, 9, 6);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('i_양말', 1700, 9, 7);
INSERT INTO product (name, price, brand_id, category_id) VALUES ('i_액세서리', 2400, 9, 8);
