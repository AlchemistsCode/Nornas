CREATE TABLE alchemy.cxt_schedulers(
  cxi_scheduler SERIAL NOT NULL,
  instance_name character varying(15),
  instance_class character varying(65),
  thread_count numeric(2,0),
  priority numeric(2,0),
  status boolean,
  CONSTRAINT cxp_scheduler PRIMARY KEY (cxi_scheduler)
);

CREATE TABLE alchemy.cxt_triggers(
  cxi_trigger serial NOT NULL,
  trigger_name character varying(15),
  trigger_group character varying(15),
  scheduler integer NOT NULL,
  created_date date,
  last_modified_date date,
  status boolean,
  CONSTRAINT cxp_trigger PRIMARY KEY (cxi_trigger)
);
CREATE TABLE alchemy.cxt_jobs(
  cxi_job serial NOT NULL,
  job_name character varying(15),
  job_class character varying(65),
  description character varying(140),
  cron_expression character varying(35),
  parameters character varying(500),
  trigger integer  NOT NULL,
  created_date date,
  first_run_date date,
  last_run_date date,
  next_run_date date,
  status boolean,
  CONSTRAINT cxp_job PRIMARY KEY (cxi_job)
);

ALTER TABLE alchemy.cxt_jobs OWNER TO developer;

ALTER TABLE alchemy.cxt_triggers ADD CONSTRAINT fk_trigger_scheduler FOREIGN KEY (scheduler)
REFERENCES alchemy.cxt_schedulers (cxi_scheduler) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE alchemy.cxt_jobs ADD CONSTRAINT fk_job_trigger FOREIGN KEY (trigger)
REFERENCES alchemy.cxt_triggers (cxi_trigger) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;