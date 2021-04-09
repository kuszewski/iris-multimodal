/// Helper class for Summit 2020 Java client demo
Class User.SummitAssigner
{

ClassMethod AssignParticipantsToCohorts() as %Status
{
  &sql(
        UPDATE summit.participant AS p 
        SET p.cohortID = MOD(p.ID, c.ID) + 1 
        FROM (
            SELECT MAX(ID) AS ID FROM summit.cohort
        ) AS c 
        WHERE p.cohortID IS NULL
    )
  Quit $$$OK
}

ClassMethod GetUntestedParticipants() as %List
{
  &sql(SELECT %DLIST(p.ID)
       INTO :pid
       FROM summit.Participant p
       WHERE p.ID not in (select participantID from summit.TestResult))

  Quit pid
}

}