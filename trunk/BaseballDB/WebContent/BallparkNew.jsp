
<HTML>
<HEAD>
<TITLE>Create New Ballpark</TITLE>
<SCRIPT LANGUAGE="JavaScript">
<!--
function validateForm()
{
var count=0;
var msg="";

    for(i=0;i<=4;i++)
    {
        if(document.UD.elements[i].value=="")
        {
        count=1;
        msg=msg+"\n"+document.UD.elements[i].name;
        }
        else if((i>3) && (count==0))
        {
            return(true);
        }
    }
    for(i=0;i<=4;i++)
    {
        if(document.UD.elements[i].value=="")
        {
        alert("PLEASE FILL IN THE FOLLOWING FIELD(S)\n "+msg);
        document.UD.elements[i].focus();
        return(false);
        }

    }


}
//-->
</SCRIPT>
</HEAD>

<BODY>
<CENTER>
<FONT SIZE="5" COLOR="#006600" FACE="verdana">Create New Ballpark</FONT>
</CENTER><BR><BR>
<FORM METHOD=POST ACTION="DBChangeServlet">
<TABLE ALIGN="CENTER">
<TR>
    <TD>Capacity</TD>
    <TD><INPUT TYPE="TEXT" NAME="CAPACITY" maxlength="5"></TD>
</TR>
<TR>
    <TD>Name</TD>
    <TD><INPUT TYPE="TEXT" NAME="NAME" maxlength="20"></TD>
</TR>
<TR>
    <TD>Year Built</TD>
    <TD><INPUT TYPE="TEXT" NAME="YEARBUILT" maxlength="4"></TD>
</TR>
<TR>
    <TD>Type</TD>
    <TD>
		<select name="TYPE">
		<option value="Grass">Grass</option>
		<option value="AstroTurf">AstroTurf</option>
		<option value="FieldTurf" selected="selected">FieldTurf</option>
		<option value="NexTurf">NexTurf</option>
		</select></TD>
</TR>
<TR>
    <TD>
    <input type="SUBMIT" name="DBChange" value="ballpark create submit"   
    onClick="return validateForm()"></TD>
    <TD><INPUT TYPE="RESET" VALUE="Reset"></TD>
</TR>
</TABLE>
</FORM>
</BODY>
</HTML>

