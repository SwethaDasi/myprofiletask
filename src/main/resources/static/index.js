const item = {
    security_token: "b4a2591f4dec919fa3954523bf35a8c9",
    user_account: "swetha.d"
};
function getMyManagers() {
    $.ajax({
        type: "POST",
        url: "https://api.kgisl.com/talentx/web/api/get-associate-detail",
        method: "POST",
        headers: {
            "content-type": "application/x-www-form-urlencoded",
        },
        data: item,
        success: function (result) {
            console.log(result);
            console.log(result.profile.ApprovalHierarchy);
            _displayItems(result.profile.ApprovalHierarchy);
        },
        error: function (result) {
            alert("msg");
        },
    });
}
function _displayItems(data) {
    const tBody = document.getElementById("managers");
    tBody.innerHTML = "";
 
    data.forEach((item) => {
        let tr = tBody.insertRow();
 
        let td2 = tr.insertCell(0);
        let approval_level = document.createTextNode(item.approval_level);
        td2.appendChild(approval_level);
 
        let td3 = tr.insertCell(1);
        let sam_acc_name = document.createTextNode(item.sam_acc_name);
        td3.appendChild(sam_acc_name);
 
        let td4 = tr.insertCell(2);
        let email = document.createTextNode(item.email);
        td4.appendChild(email);
    });
}
    function saveMyprofile(){
        console.log("save Myprofile function calling....");
        let myprofile={
            "bussinessvertical": "GSS",
            "designation": "Trainee",
            "id": 1,
            "myapproval": [
              {
                "email": "swetha.d@gmail.com",
                "empId": "111",
                "id": 1,
                "level": "1",
                "name": "swetha.d"
              }
            ],
            "myprofileId": "1",
            "myprofilename": "swetha.d",
            "project": "springboot"
          }
        };


