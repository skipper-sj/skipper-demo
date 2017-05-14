#! /bin/bash
set -e

bin=/opt/elasticsearch-jdbc-2.3.4.0/bin
lib=/opt/elasticsearch-jdbc-2.3.4.0/lib

sqlString='"sql":[
                    {
        "statement":"SELECT tfo.id AS _id, tfo.id AS finance_order_id,tfo.city_id AS finance_order_city_id,tfo.order_center_no AS finance_order_center_no,tfo.customer_id AS finance_order_customer_id,tfo.product_id AS finance_order_product_id,tfo.process_instance_id AS finance_order_process_instance_id,tfo.is_deleted AS finance_order_is_deleted,tfo.create_time AS finance_order_create_time,tfo.update_time AS finance_order_update_time,tfo.sys_time AS finance_order_sys_time,tfo.delete_time AS finance_order_deleted_time,tflo.id AS finance_loan_order_id,tflo.loan_amount AS finance_loan_order_amount,tflo.loan_period AS finance_loan_order_period,tflo.period_unit AS finance_loan_order_period_unit,tflo.loan_apply_time AS finance_loan_order_apply_time,tflo.loan_purpose AS finance_loan_order_purpose,tflo.city_id AS finance_loan_order_city_id,tflo.city_live_years AS finance_city_live_years,tflo.customer_source_id AS finance_customer_source_id,tflo.applicant_id AS finance_application_id,tflo.interview_result AS finance_interview_result,tflo.interview_remark AS finance_interview_remark,tflo.loan_status AS finance_loan_order_status,tflo.order_repayment_time AS finance_order_repayment_time,tflo.create_time AS finance_loan_order_create_time,tflo.update_time AS finance_loan_order_update_time,tflo.sys_time AS finance_loan_order_sys_time,tfc.id AS finance_order_customer_id,tfc.name AS finance_order_customer_name,tfc.phone AS finance_order_cutomer_phone,tfc.type AS finance_order_customer_type,tfc.person_id AS finance_order_customer_person_id,tfc.company_id AS finance_order_customer_company_id,tfc.is_deleted AS finance_order_customer_is_deleted,tfc.create_time AS finance_order_customer_create_time,tfc.update_time AS finance_order_customer_update_time,tfc.sys_time AS finance_order_customer_sys_time,tfpps.id AS finance_status_id,tfpps.parent_id AS finance_status_parent_id,tfpps.name AS finance_status_name,tfpps.deepth AS finance_status_deepth,tfpps.seq AS finance_status_seq,tfpps.product_id AS finance_status_product_id,tfpps.create_time AS finance_status_create_time,tfpps.update_time AS finance_status_update_time,tfpps.sys_time AS finance_status_sys_time,cslog.operate_time AS finance_trial_operation_time,gblog.operate_time AS finance_close_operation_time FROM tfs_order tfo LEFT JOIN tfs_loan_order tflo ON tfo.id = tflo.order_id LEFT JOIN tfs_customer tfc ON tfc.id = tfo.customer_id LEFT JOIN tfs_product_phase_status tfpps ON tfpps.id = tflo.loan_status LEFT JOIN (SELECT * FROM tfs_audit_log WHERE id IN (SELECT min(id) FROM tfs_audit_log WHERE order_status = 302 AND operate_type = 0)) cslog ON cslog.order_id = tfo.id LEFT JOIN (SELECT * FROM tfs_audit_log WHERE id IN (SELECT min(id) FROM tfs_audit_log WHERE operate_type = 1)) gblog ON gblog.order_id = tfo.id'

if [[ $1 = all ]];
then
        sqlparam=';"
                    }
                ],
'
else
        schedule='"schedule": "0 0/1 0-23 ? * *",'
        statefile='"statefile": "logs/finance-order.json",'
        sqlparam=' where (tfo.sys_time>date_add(?, INTERVAL -5 Second) or tflo.sys_time>date_add(?, INTERVAL -5 Second) or tfc.sys_time>date_add(?, INTERVAL -5 Second) or tfpps.sys_time>date_add(?, INTERVAL -5 Second));",
               "parameter": ["$metrics.lastexecutionstart","$metrics.lastexecutionstart","$metrics.lastexecutionstart","$metrics.lastexecutionstart"]
                    }
                ],
'
fi


eshead='{
        "type": "jdbc",
        "jdbc": {
                "url": "'$finance_url'",
                "user": "'$finance_user'",
                "password": "'$finance_password'",'
estail='"elasticsearch.cluster": "'$elasticsearch_cluster_name'",
                "elasticsearch.host": "'$elasticsearch_hosts'",
                "elasticsearch.port": "9200",
                "index": "'$elasticsearch_order_index'",
                "scale": -1,
                "type": "order"
        }
}'

esString=${eshead}${statefile}${schedule}${sqlString}${sqlparam}${estail}
echo "$esString"

echo "$esString" | java \
-cp "${lib}/*" \
-Dlog4j.configurationFile=${bin}/log4j2.xml \
-Xmx512m -Xms512m -XX:+HeapDumpOnOutOfMemoryError \
org.xbib.tools.Runner \
org.xbib.tools.JDBCImporter

