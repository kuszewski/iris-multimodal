/// Helper class for Summit 2020 Java client demo
Class User.CohortAssigner
{

ClassMethod AssignParticipantsToCohorts() As %Status
{
  &sql(
        UPDATE demo.participant AS p 
        SET p.cohortID = MOD(p.ID, c.ID) + 1 
        FROM (
            SELECT MAX(ID) AS ID FROM demo.cohort
        ) AS c 
        WHERE p.cohortID IS NULL
    )
  Quit $$$OK
}

ClassMethod GetUntestedParticipants() As %List
{
  &sql(SELECT %DLIST(p.ID)
       INTO :pid
       FROM demo.Participant p
       WHERE p.ID not in (select participantID from demo.TestResult))

  Quit pid
}

}
