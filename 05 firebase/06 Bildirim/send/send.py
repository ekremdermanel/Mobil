
import requests
import json

from oauth2client.service_account import ServiceAccountCredentials
fsm_scope = 'https://www.googleapis.com/auth/firebase.messaging'

def _get_access_token():
    """Retrieve a valid access token that can be used to authorize requests.
    :return: Access token.
    """
    credentials = ServiceAccountCredentials.from_json_keyfile_name(
        'service-account.json', fsm_scope)
    access_token_info = credentials.get_access_token()
    return access_token_info.access_token

_project_id='news-91dd0'

_url = 'https://fcm.googleapis.com/v1/projects/%s/messages:send' %(_project_id)
#_access_token = 'ya29.a0AfB_byAnV0wbk_jqHMEophUulRZVc4fmMB-Fw8_VUkuvMuYymDuIYgORZ2-NcievUlzpvtD7XIQG9hFaM6vWMSJXFwYJ06HjTIu23FOSVOEU25Tn0XIxYaQxvVDC5t5Sq00fCyoi9cvPNzNNnr_Q-IlQ1JaVj7NZghvZaCgYKAZQSARMSFQHGX2MisWsHcZ8BXXmvESd9NSMfpQ0171'
_access_token = _get_access_token()
_headers = {
  'Authorization': 'Bearer ' + _access_token,
  'Content-Type': 'application/json',
}

_body = {
  'message':{
     'token':'cfCzwaReTIyCLeiaNa9MR7:APA91bE8FbZnnbd2Z_UmgQeyYEOXvpod72YKK5wxmWRZo7U1_vDj4vlIK2Eo0DJuzrl_U7XqxUoxuW4_-XXt7fyx36uD1LIBtZq_lrHC_C9QjPtTwt4w8nIrfM-xx88X8W4cRdO2hR-Y',
     'notification':{
       'body':'This is pytohn',
       'title':'FCM Message postman'
     }
  }
}

myobj = {'somekey': 'somevalue'}


x = requests.post(_url, data=json.dumps(_body), headers = _headers)
print(x.text)
