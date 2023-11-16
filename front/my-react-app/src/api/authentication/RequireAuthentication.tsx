import { Navigate, useLocation } from 'react-router-dom'
import { useAuthentication } from './AuthenticationContext'
import Layout from '../../layout/layout'

export const RequireAuth = (children: any) => {
    const location = useLocation()
    const auth = useAuthentication()
    if (!auth.isAuthenticated) {
        return <Navigate to='/' state={{ path: location.pathname }} />
    }
    return <Layout>{children}</Layout>
}