%{
	/*To find whether given letter is a vowel or not*/
void display(int,char*);
int flag;
%}

%%
[a|e|i|o|u|A|E|I|O|U] {flag=1;display(flag,yytext);}
. {flag=0;display(flag,yytext);}
%%

int yywrap(){return 1;}
void main()
{
	printf("\nEnter a letter to check if it is a vowel or not: ");
	yylex(); 
}
void display(int flag,char*t)
{
	if(flag==1)
	{
		printf("\nThe given letter %s is a vowel\n",t);
		}
	else
	{
		printf("\nThe given letter %s is not a vowel\n",t);
		}		
}