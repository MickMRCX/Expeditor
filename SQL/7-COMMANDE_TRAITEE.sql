USE [Expeditor]
GO

/****** Object:  Table [dbo].[Commande_Traitee]    Script Date: 21/06/2016 14:03:08 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Commande_Traitee](
	[Utilisateur_id] [int] NOT NULL,
	[Commande_id] [int] NOT NULL,
	[Date] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Utilisateur_id] ASC,
	[Commande_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Commande_Traitee]  WITH CHECK ADD  CONSTRAINT [FK_Commande_Traitee_Commande] FOREIGN KEY([Commande_id])
REFERENCES [dbo].[Commande] ([Identifiant])
GO

ALTER TABLE [dbo].[Commande_Traitee] CHECK CONSTRAINT [FK_Commande_Traitee_Commande]
GO

ALTER TABLE [dbo].[Commande_Traitee]  WITH CHECK ADD  CONSTRAINT [FK_Commande_Traitee_Utilisateurs] FOREIGN KEY([Utilisateur_id])
REFERENCES [dbo].[Utilisateurs] ([Identifiant])
GO

ALTER TABLE [dbo].[Commande_Traitee] CHECK CONSTRAINT [FK_Commande_Traitee_Utilisateurs]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Table des commandes traitées' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Commande_Traitee'
GO

