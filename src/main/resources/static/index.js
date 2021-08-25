const item = {
    security_token: "b4a2591f4dec919fa3954523bf35a8c9",
    user_account: "swetha.d",
  };
  const userAccount = "";
  var profileid = "";
  var empid = "";
  var empname = "";
  var designation = "";
  var businessVertical = "";
  var project = "";
  function getMyManagers() {
    // alert("getMyManagers() function called");
    const item = {
      security_token: "b4a2591f4dec919fa3954523bf35a8c9",
      user_account: this.userAccount,
    };
    console.log(item);
    $.ajax({
      type: "POST",
      url: "https://api.kgisl.com/talentx/web/api/get-associate-detail",
      method: "POST",
      headers: {
        "content-type": "application/x-www-form-urlencoded",
      },
      data: item,
      success: function (result) {
          // associate_code   sam_acc_name    designation business_vertical   project
        console.log(result);
        console.log(result.profile.ApprovalHierarchy);
        console.log(result.profile.practice_group);
        empid=result.profile.associate_code;
        empname=result.profile.sam_acc_name;
        designation=result.profile.designation;
        businessVertical=result.profile.business_vertical;
        project=result.profile.project;
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
      let associate_code = document.createTextNode(item.associate_code);
      td3.appendChild(associate_code);
      let td4 = tr.insertCell(2);
      let sam_acc_name = document.createTextNode(item.sam_acc_name);
      td4.appendChild(sam_acc_name);
      let td5 = tr.insertCell(3);
      let email = document.createTextNode(item.email);
      td5.appendChild(email);
      let td6 = tr.insertCell(4);
      let id = document.createTextNode("0");
      td6.appendChild(id);
    });
  }
  function saveMyProfile() {
    //   console.log("saveMyProfile function calling...");
    var table = $("#tblManagers").tableToJSON();    
    console.log(JSON.stringify(table));
    let myProfile = {
      business: this.businessVertical,
      designation: this.designation,
      empid: this.empid,
      empname: this.empname,
      project: this.project,
      profileid: 0,    
      myApproval:table 
    };
    //   ajax
    console.log(JSON.stringify(myProfile));
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/api/myprofiles/post",
      data: JSON.stringify(myProfile),
      contentType: "application/json",
      success: function (result) {
        //   getItems();
      },
      error: function (result) {
        alert("msg");
      },
    });
  }
  function drpdown() {
    console.log("drpdown method calling");
    this.userAccount = document.getElementById("dd").value;
    console.log(document.getElementById("dd").value);
    const item = {
      security_token: "b4a2591f4dec919fa3954523bf35a8c9",
      user_account: this.userAccount,
    };
    console.log(item);
    getMyManagers();
  }
 
function fileupload() {
  console.log("file upload called");
  var url = "YOUR-BASE-URL-HERE"; //Like http://localhost:8081
  var form = $('#form-upload')[0]; //get the form containing the files
  var data = new FormData(form);
  $.ajax({
    url: "/api/files/upload",
    type: "POST",
    enctype: 'multipart/form-data',
    data: data, //pass the form data
    processData: false,
    contentType: false,
    success: function (data) {
        console.log("Successfully uploaded " + data);
    },
    error: function (data) {
        console.log("upload failed");
    }
  });
} 
