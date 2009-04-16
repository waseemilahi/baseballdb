
<HTML>
<HEAD>
<TITLE>Create New Division</TITLE>
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
<FONT SIZE="5" COLOR="#006600" FACE="verdana">Create New Division</FONT>
</CENTER><BR><BR>
<FORM METHOD=POST ACTION="DBChangeServlet">
<TABLE ALIGN="CENTER">
<TR>
    <TD>Location</TD>
    <TD>
		<select name="LOCATION">
			<option value="EAST">EAST</option>
			<option value="CENTRAL">CENTRAL</option>
			<option value="WEST" selected="selected">WEST</option>
		</select></TD>

</TR>
<TR>
    <TD>League</TD>
    <TD>
		<select name="LEAGUE">
		<option value="AL">American League</option>
		<option value="NL" selected="selected">National League</option>
		</select></TD>
</TR>
<TR>
    <TD>
    <input type="SUBMIT" name="DBChange" value="division create submit"   
    onClick="return validateForm()"></TD>
    <TD><INPUT TYPE="RESET" VALUE="Reset"></TD>
</TR>
</TABLE>
</FORM>
</BODY>
</HTML>

