SELECT c.description, COUNT(p.ID) AS TotalParticipants, COUNT(t.ID) AS TotalTests, COUNT(t.clinicalInfo %AFTERHAVING) AS SuccessfulTests 
FROM demo.participant p, ISC_DM.testresult t, demo.cohort c
WHERE t.patientID = p.ID AND p.cohortID = c.ID
GROUP BY c.ID
HAVING t.clinicalInfo = 'NOT DETECTED'
ORDER BY c.ID
