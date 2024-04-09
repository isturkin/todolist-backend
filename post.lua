wrk.method = "POST"
wrk.body='{ "text": "Add tests 2", "status": "NEW", "projectId": 1 }'
wrk.headers["Content-Type"] = "application/json"