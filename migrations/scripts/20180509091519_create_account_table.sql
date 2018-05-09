--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // create account table
CREATE TABLE IF NOT EXISTS account(id BIGINT PRIMARY KEY, name VARCHAR(60) NOT NULL);

CREATE SEQUENCE IF NOT EXISTS account_id_seq AS BIGINT INCREMENT BY 1;

INSERT INTO account
VALUES
(NEXTVAL('account_id_seq'), 'test common account'),
(NEXTVAL('account_id_seq'), 'test personal account');



-- //@UNDO
DROP TABLE IF EXISTS account;

DROP SEQUENCE IF EXISTS account_id_seq;

