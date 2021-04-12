Class demo.Session Extends (%Persistent)
{

Property Key As %VarString;

Property Value As %VarString;

Property Created As %Library.UTC [ InitialExpression = {##class(%Library.UTC).NowUTC()} ];

Property LastUsed As %Library.UTC [ InitialExpression = {##class(%Library.UTC).NowUTC()} ];

Index KeyIndex On Key [ IdKey ];

Index LastUsedIndex On LastUsed;

Storage Default
{
<Data name="SessionDefaultData">
<Value name="1">
<Value>%%CLASSNAME</Value>
</Value>
<Value name="2">
<Value>Key</Value>
</Value>
<Value name="3">
<Value>Value</Value>
</Value>
<Value name="4">
<Value>Created</Value>
</Value>
<Value name="5">
<Value>LastUsed</Value>
</Value>
</Data>
<DataLocation>^demo.SessionD</DataLocation>
<DefaultData>SessionDefaultData</DefaultData>
<IdLocation>^demo.SessionD</IdLocation>
<IndexLocation>^demo.SessionI</IndexLocation>
<StreamLocation>^demo.SessionS</StreamLocation>
<Type>%Storage.Persistent</Type>
}

}
