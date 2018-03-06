$(function() {

});

function submitJob() {
    var jobDetail = buildMessage();
    if (validateJob(jobDetail)) {
        callServer('/apply', jobDetail, applyCallback);
    }
}

function clearMessages() {
    $('#errors').empty();
}

function addMessage(text) {
    $('#errors').append('<div class="alert alert-warning alert-dismissible" role="alert">'
        + '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>'
        + text + '</div>');
}

function addError(text) {
    $('#errors').append('<div class="alert alert-danger" role="alert">' + text + '</div>');
}

function validateJob(jobDetail) {
    var i, len, key, alreadyDisplayedExpandedMessage;
    var keys = Object.keys(jobDetail);
    var ret = true;
    clearMessages();

    if (!validateJobName(jobDetail.jobName)) {
        ret = false;
    }
    if (!validateTeam(jobDetail.team)) {
        ret = false;
    }
    for (i = 0, len = keys.length; i < len; i++) {
        key = keys[i];
        if (jobDetail[key] === '' && (key.indexOf('-fork') > -1 || key.indexOf('-branch') > -1)) {
            makePanelDangerous(key);
            ret = false;
            if (!alreadyDisplayedExpandedMessage) {
                alreadyDisplayedExpandedMessage = true;
                addError('All expanded projects are required.');
            }
        }
    }
    return ret;
}

function callServer(url, params, callback) {
    $.ajax({
        type: 'POST',
        url : url,
        async : true,
        cache : false,
        data : JSON.stringify(params),
        dataType : 'json',
        contentType: 'application/json',
        complete: function(data) {
            callback(data.responseJSON);
        }
    });
}