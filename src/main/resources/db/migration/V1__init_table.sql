CREATE TABLE "device"
(
    "id"          uuid      NOT NULL,
    "name"        varchar   NOT NULL,
    "description" varchar,
    "create_time" timestamp NOT NULL,
    "update_time" timestamp NOT NULL,
    "metadata"    json,
    PRIMARY KEY ("id")
)
;

COMMENT
ON COLUMN "device"."name" IS 'unique resource name';

COMMENT
ON COLUMN "device"."description" IS 'device description info';

COMMENT
ON COLUMN "device"."create_time" IS 'device create time';

COMMENT
ON COLUMN "device"."update_time" IS 'device update time';
