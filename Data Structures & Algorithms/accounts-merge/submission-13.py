class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:

        emailIdx = {}
        emails = []
        emailToAcc = {}

        m = 0

        for accId, a in enumerate(accounts):
            for i in range(1, len(a)):
                if a[i] in emailIdx:
                    continue

                emailIdx[a[i]] = m
                emails.append(a[i])
                emailToAcc[m] = accId
                m += 1

        adj = [[] for _ in range(m)]

        for account in accounts:
            for i in range(2, len(account)):
                idx1 = emailIdx[account[i]]
                idx2 = emailIdx[account[i - 1]]

                adj[idx1].append(idx2)
                adj[idx2].append(idx1)

        
        visited = [False] * m
        emailGroup = defaultdict(list)

        def dfs(node, accId):

            visited[node] = True
            emailGroup[accId].append(emails[node])

            for nei in adj[node]:
                if not visited[nei]:
                    dfs(nei, accId)


        for i in range(m):
            if not visited[i]:
                dfs(i, emailToAcc[i])

        res = []

        for accId in emailGroup:
            name = accounts[accId][0]

            res.append([name] + sorted(emailGroup[accId]))

        return res


            




        